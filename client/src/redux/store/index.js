import { combineReducers, configureStore } from '@reduxjs/toolkit'
import plannerReducer from '../reducers/planner-reducer.js'

const mainReducer = combineReducers({
    planner: plannerReducer
})

export const store = configureStore({
    reducer: mainReducer
})