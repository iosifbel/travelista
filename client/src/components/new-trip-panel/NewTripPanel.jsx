import React, { useEffect, useRef, useState } from 'react'
import { DatesPicker } from '../dates-picker/DatesPicker'
import SearchResults from '../search-results/SearchResults'

import './new-trip-panel.css'

export const NewTripPanel = () => {

  const searchRef = useRef()
  const [showSearchResults, setShowSearchResults] = useState(false)

  useEffect(() => {

    const handleShowSearch = (e) => {
      if(!searchRef.current.contains(e.target)) {
        setShowSearchResults(false)
      }
    }

    document.addEventListener('mousedown', handleShowSearch)

    return () => {
      document.removeEventListener("mousedown", handleShowSearch)
    }
  }, [])
  

  return (
    <div className='new-trip-panel'>
        <h2>Plan a new trip</h2>
        {console.log(showSearchResults)}
        <div className="search-location">
            <span className='text'>Where to</span>
            <input type="text" onFocus={(e) => setShowSearchResults(true)} placeholder='Nepal, Alaska, Caracal' className='input'/>
            {showSearchResults && <SearchResults showRef={searchRef}/>}
            
        </div>
        <DatesPicker />
    </div>
  )
}
