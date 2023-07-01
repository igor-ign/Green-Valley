import { useDispatch } from "react-redux";
import { closeToast, errorToast, successToast } from "../slices/toastSlice";
import { DEFAULT_TOAST_DURATION } from "../app-constants";

export function useToast() {
    const dispatch = useDispatch()

    function showSuccessToastWithAutoClose(message) {
        dispatch(successToast(message))

        setTimeout(() => {
            dispatch(closeToast())
        }, DEFAULT_TOAST_DURATION)
    }

    function showErrorToastWithAutoClose(message) {
        dispatch(errorToast(message))

        setTimeout(() => {
            dispatch(closeToast())
        }, DEFAULT_TOAST_DURATION)
    }

    return {
        showSuccessToastWithAutoClose,
        showErrorToastWithAutoClose
    }
}