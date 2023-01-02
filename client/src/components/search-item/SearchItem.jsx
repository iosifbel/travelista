import React from "react";

import "./search-item.css";

const SearchItem = () => {
  return (
    <div className="search-item">
      <div>
        <span className="name">New Delhi</span>
        <span className="country">India</span>
      </div>
      <span className="type">State</span>
    </div>
  );
};

export default SearchItem;
