import React from 'react'
import SearchItem from '../search-item/SearchItem'

import './search-results.css'

const SearchResults = ({showRef}) => {
  return (
    <div className='search-results' ref={showRef}>
        <SearchItem />
        <SearchItem />
        <SearchItem />
        <SearchItem />
    </div>
  )
}

export default SearchResults