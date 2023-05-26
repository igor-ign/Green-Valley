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
      {items.map((item) => {
        return (
          <li key={item.id} className="list__item">
            <div className="item__content--id">{item.id}</div>
            <div className="item__content">{item.location}</div>
            <div className="item__content">{item.type}</div>
            <div className="item__content">{item.price}</div>
            {!!possibleActions && renderPossibleActions()}
          </li>
        );
      })}
    </ul>
  );
}
