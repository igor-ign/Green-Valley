import { ADMIN_NAVBAR_ITEMS } from "../../../../app-constants";
import { NavbarItem } from "../navbar-item";

export function NavbarItems() {
  return (
    <>
      {ADMIN_NAVBAR_ITEMS.map((item) => {
        return (
          <NavbarItem
            itemKey={item.itemKey}
            path={item.path}
            name={item.name}
            icon={item.icon}
          />
        );
      })}
    </>
  );
}
