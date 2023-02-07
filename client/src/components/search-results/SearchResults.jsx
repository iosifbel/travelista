import React from 'react'
import SearchItem from '../search-item/SearchItem'

import './search-results.css'

const SearchResults = ({showRef, results}) => {
  return (
    <div className='search-results' ref={showRef}>
        {results.map(location => (
          <SearchItem location={location} key={location.name}/>
        ))}
    </div>
  )
}

export default SearchResults