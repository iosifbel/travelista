import React, { useEffect, useRef, useState } from "react";
import useDebounce from "../../hooks/useDebounce";
import { DatesPicker } from "../dates-picker/DatesPicker";
import SearchResults from "../search-results/SearchResults";

import "./new-trip-panel.css";

export const NewTripPanel = () => {
  const searchRef = useRef();
  const [searchResults, setSearchResults] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [showSearchResults, setShowSearchResults] = useState(true);

  const debounce = (func, delay) => {
    let timer;
    return (...arg) => {
      if (timer) clearTimeout(timer);
      timer = setTimeout(() => {
        func(...arg);
      }, delay);
    };
  };

  const fetchResults = async (e) => {
    if (e.target.value) {
      const baseEndpoint = process.env.REACT_APP_BASE_ENDPOINT;
      const res = await fetch(
        `${baseEndpoint}/destinations/autocomplete?input=${e.target.value}`
      );

      if (res.ok) {
        const results = await res.json();
        setSearchResults(results);
      }
    } else {
      setSearchResults([])
    }
  };

  const searchHandler = debounce(fetchResults, 500);

  useEffect(() => {
    const handleShowSearch = (e) => {
      if (e.path[0] !== searchRef.current) {
        setShowSearchResults(false);
      }
    };

    document.addEventListener("mousedown", handleShowSearch);

    return () => {
      document.removeEventListener("mousedown", handleShowSearch);
    };
  }, []);

  return (
    <div className="new-trip-panel">
      <h2>Plan a new trip</h2>
      <div className="search-location">
        {console.log(searchResults)}
        <span className="text">Where to</span>
        <input
          type="text"
          onChange={(e) => searchHandler(e)}
          placeholder="Nepal, Alaska, Caracal"
          className="input"
        />
        {showSearchResults ? searchResults.length ? (
          <SearchResults results={searchResults} showRef={searchRef} />
        ) : null : ''}
      </div>
      <DatesPicker />
    </div>
  );
};
