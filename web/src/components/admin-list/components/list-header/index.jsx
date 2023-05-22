import "./style.scss";

export function ListHeader({ headerItems, possibleActions }) {
  // TODO: Think about letting the components who have this one as a child to decide how SOME styles will behave
  return (
    <header className="list__header">
      <ul className="header__list" type="none">
        {headerItems.map((item) => {
          return (
            <li
              className={`list__item ${
                headerItems.indexOf(item) === 0 ? "--id" : ""
              }`}
            >
              {item}
            </li>
          );
        })}

        {!!possibleActions && <li className="list__item">Actions</li>}
      </ul>
    </header>
  );
}
