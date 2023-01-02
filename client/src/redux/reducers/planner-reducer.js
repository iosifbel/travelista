import { UPDATE_SELECTED_DATES } from "../actions/planner.js";

const intialState = {
  location: null,
  selectedDates: null
};

const plannerReducer = (state = intialState, action) => {
  switch (action.type) {
    case "SELECT_LOCATION":
      return {
        ...state,
        location: action.payload,
      };
    case UPDATE_SELECTED_DATES:
        return {
            ...state,
            selectedDates: action.payload
        }
    default: 
        return state;
  }
};

export default plannerReducer;
