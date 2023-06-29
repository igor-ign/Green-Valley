export function List({ items, possibleActions }) {
  function renderPossibleActions() {
    // TODO: create a state to be used by this button onClick event
    return (
      <div className="item__content">
        {possibleActions.map((action) => (
          <button className="action__button">{action.icon}</button>
        ))}
      </div>
    );
  }

  return (
    <ul className="page__list" type="none">
      {items?.map((item) => {
        return (
          <li key={`${item.id}`} className="list__item">
            {Object.keys(item).map((key) => {
              if (key !== "id")
                return <div className="item__content">{item[key]}</div>;
            })}
            {!!possibleActions && renderPossibleActions()}
          </li>
        );
      })}
    </ul>
  );
}
