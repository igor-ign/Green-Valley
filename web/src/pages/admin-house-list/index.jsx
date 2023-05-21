import { AdminHeader, AdminList } from "../../components";
import { HOUSES_LIST_HEADER_ITEMS } from "./constants";
import "./style.scss";

export function AdminHouses() {
  // TODO: Remove this mock data when api is ready.
  const MOCK_DATA = [
    {
      id: 1,
      location: "Brooklyn, New York",
      type: "BUY",
      price: "$300.000,00",
    },
    {
      id: 2,
      location: "Brooklyn, New York",
      type: "BUY",
      price: "$300.000,00",
    },
    {
      id: 3,
      location: "Brooklyn, New York",
      type: "RENT",
      price: "$300.000,00",
    },
    {
      id: 4,
      location: "Brooklyn, New York",
      type: "BUY",
      price: "$300.000,00",
    },
    {
      id: 5,
      location: "Brooklyn, New York",
      type: "RENT",
      price: "$300.000,00",
    },
    {
      id: 6,
      location: "Brooklyn, New York",
      type: "RENT",
      price: "$300.000,00",
    },
  ];

  return (
    <div>
      <AdminHeader title={"Houses"} />
      <AdminList listItems={MOCK_DATA} headerItems={HOUSES_LIST_HEADER_ITEMS} />
      {/*TODO: Create a separated component responsible to return a object containing all possible steps. Also remember to create a state
      to control those steps!
      */}
    </div>
  );
}
