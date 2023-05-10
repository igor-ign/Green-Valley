import { createSlice } from '@reduxjs/toolkit'

export const userSlice = createSlice({
  name: 'user',
  initialState: {
    token: ''
  },
  reducers: {
    addToken(state, action) {
        state.push(action.payload)
    }
  }
})

export const { addToken } = userSlice.actions

export default userSlice.reducer