import { ListHeader } from "./components";
import "./style.scss";

export function AdminList({ listItems, headerItems, possibleActions = "" }) {
  return (
    <div className="houses__list">
      <ListHeader headerItems={headerItems} possibleActions={possibleActions} />
      <div>List</div>
    </div>
  );
}
