import { createSlice } from '@reduxjs/toolkit'

export const userSlice = createSlice({
  name: 'user',
  initialState: {
    token: ''
  },
  reducers: {
    addToken(state, action) {
        state.value = action.payload
    },
    logout(state) {
      state.value = {token: ''}
    }
  }
})

export const { addToken, logout } = userSlice.actions

export default userSlice.reducer