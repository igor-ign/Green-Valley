export function ListHeader({ headerItems, possibleActions }) {
  return (
    <header className="list__header">
      <ul className="header__list" type="none">
        {headerItems.map((item) => {
          return (
            <li
              className={`header__list__item ${
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
