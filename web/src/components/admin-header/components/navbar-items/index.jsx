import { ADMIN_NAVBAR_ITEMS } from "../../../../app-constants";
import { NavbarItem } from "../navbar-item";

export function NavbarItems() {
  return (
    <>
      {ADMIN_NAVBAR_ITEMS.map((item) => {
        return (
          <NavbarItem
            key={item.key}
            path={item.path}
            name={item.name}
            icon={item.icon}
          />
        );
      })}
    </>
  );
}
