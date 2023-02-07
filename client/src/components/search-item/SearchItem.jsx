import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { selectLocation } from "../../redux/actions/planner";

import "./search-item.css";

const SearchItem = ({ location }) => {

  const dispatch = useDispatch()

  const handleClick = () => {
    dispatch(selectLocation(location))
  }

  return (
    <div className="search-item" onClick={handleClick}>
      <div>
        <span className="name">{location.name}</span>
        <span className="country">{location.country}</span>
      </div>
      <span className="type">{location.type}</span>
    </div>
  );
};

export default SearchItem;
