import { useEffect, useState } from "react";
import { HOUSE_LIST_SCREENS } from "../../app-constants";
import { AdminHeader, AdminList, CreateButton } from "../../components";
import { useHouses } from "../../hooks";
import { HOUSES_LIST_HEADER_ITEMS, INITIAL_FILTERS } from "./constants";
import "./style.scss";

export function AdminHouses() {
  const [currentScreen, setCurrentScreen] = useState(
    HOUSE_LIST_SCREENS.INITIAL
  );
  const [data, setData] = useState();
  const [filters, setFilters] = useState(INITIAL_FILTERS);
  const { getHouses } = useHouses();

  useEffect(() => {
    async function getAllHouses() {
      try {
        const params = {
          id: filters.id,
          neighborhoodId: filters.neighborhoodId,
          maxPrice: filters.maxPrice,
          minPrice: filters.minPrice,
          type: filters.type,
        };

        const { data } = await getHouses(params);
        setData(data.content);
      } catch (error) {
        console.error(error);
        // TODO: add toast
      }
    }

    getAllHouses();
  }, [
    filters.id,
    filters.minPrice,
    filters.maxPrice,
    filters.neighborhoodId,
    filters.type,
  ]);

  return (
    <div className="admin__house__list">
      <AdminHeader title={"Houses"} />
      <AdminList listItems={data} headerItems={HOUSES_LIST_HEADER_ITEMS} />
      <CreateButton
        onClick={() => setCurrentScreen(HOUSE_LIST_SCREENS.CREATE)}
      />
      {/*TODO: Create a separated component responsible to return a object containing all possible steps. Also remember to create a state
      to control those steps!
      */}
    </div>
  );
}
