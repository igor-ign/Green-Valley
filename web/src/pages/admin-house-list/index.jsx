import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { HOUSE_LIST_SCREENS } from "../../app-constants";
import { AdminHeader, CreateButton } from "../../components";
import { useHouses } from "../../hooks";
import { successToast } from "../../slices/toastSlice";
import { INITIAL_FILTERS } from "./constants";
import { housesListSteps } from "./utils";
import "./style.scss";

export function AdminHouses() {
  const [currentScreen, setCurrentScreen] = useState(
    HOUSE_LIST_SCREENS.INITIAL
  );
  const [data, setData] = useState();
  const [filters, setFilters] = useState(INITIAL_FILTERS);
  const { getHouses } = useHouses();
  const dispatch = useDispatch();

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
        dispatch(successToast("nice!"));
      } catch (error) {
        console.error(error);
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
      {housesListSteps(data)[currentScreen]}
      <CreateButton
        onClick={() => setCurrentScreen(HOUSE_LIST_SCREENS.CREATE)}
      />
    </div>
  );
}
