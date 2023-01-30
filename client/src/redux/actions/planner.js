export const UPDATE_SELECTED_DATES = 'UPDATE_SELECTED_DATES'

export const updateSelectedDates = (dates) => {
    return {
        type: UPDATE_SELECTED_DATES,
        payload: dates
    }
}
