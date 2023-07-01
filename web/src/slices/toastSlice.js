import { createSlice } from '@reduxjs/toolkit';

export const toastSlice = createSlice({
  name: 'toast',
  initialState: {
    status: 'closed',
    type: 'none',
    message: ''
  },
  reducers: {
    successToast(state, action) {
      state.status = 'opened';
      state.type = 'success';
      state.message = action.payload;
    },
    errorToast(state, action) {
      state.status = 'opened';
      state.type = 'error';
      state.message = action.payload;
    },
    closeToast(state) {
      state.status = 'closed';
      state.type = 'none';
      state.message = '';
    }
  }
});

export const { successToast, errorToast, closeToast } = toastSlice.actions;

export default toastSlice.reducer;
