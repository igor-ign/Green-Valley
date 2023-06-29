import { ListHeader, List } from "./components";
import "./style.scss";

export function AdminList({ listItems, headerItems, possibleActions = "" }) {
  return (
    <div className="admin__list">
      <ListHeader headerItems={headerItems} possibleActions={possibleActions} />
      <List items={listItems} />
    </div>
  );
}
