export const UPDATE_SELECTED_DATES = 'UPDATE_SELECTED_DATES'
export const SELECT_LOCATION = 'SELECT_LOCATION'

export const updateSelectedDates = (dates) => {
    return {
        type: UPDATE_SELECTED_DATES,
        payload: dates
    }
}

export const selectLocation = (location) => {
    return {
        type: SELECT_LOCATION,
        payload: location
    }
}
