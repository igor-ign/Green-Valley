import { useDispatch, useSelector } from "react-redux";
import { CheckCircle, Error } from "@material-ui/icons";
import { TOAST_TYPE } from "../../app-constants";
import { closeToast } from "../../slices/toastSlice";
import "./style.scss";

export function Toast() {
  const { toast } = useSelector((state) => state);
  const dispatch = useDispatch();
  const toastIcon =
    toast.type === TOAST_TYPE.ERROR ? <Error /> : <CheckCircle />;

  return (
    <dialog className={`toast__${toast.status}--${toast.type}`}>
      <button className="toast__exit" onClick={() => dispatch(closeToast())}>
        X
      </button>
      <div className="toast__content">
        <div className={`toast__icon--${toast.type}`}>{toastIcon}</div>
        <div className={`toast__message--${toast.type}`}>{toast.message}</div>
      </div>
    </dialog>
  );
}
