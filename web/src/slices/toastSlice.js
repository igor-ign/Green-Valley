import { createSlice } from '@reduxjs/toolkit'

export const toastSlice = createSlice({
  name: 'toast',
  initialState: {
    status: 'closed',
    type: '',
    message: ''
  },
  reducers: {
    successToast(state, action) {
        state.value = action.payload
    },
    errorToast(state, action) {
      state.value = action.payload
    }
  }
})

export const { successToast, errorToast } = toastSlice.actions

export default toastSlice.reducer