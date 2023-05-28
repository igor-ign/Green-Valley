import "./style.scss";

export function CreateButton({ onClick }) {
  return (
    <button className="create__button" onClick={onClick}>
      +
    </button>
  );
}
