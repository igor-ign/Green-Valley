import { configureStore } from '@reduxjs/toolkit'
import userReducer from './slices/userSlice'
import toastReducer from './slices/toastSlice'

export default configureStore({
  reducer: {
    user: userReducer,
    toast: toastReducer 
  }
})