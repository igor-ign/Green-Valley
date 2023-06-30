import { HOUSE_LIST_SCREENS } from "../../../app-constants";
import { AdminList } from "../../../components";
import { HOUSES_LIST_HEADER_ITEMS } from "../constants";

export function housesListSteps(data) {
  return {
    [HOUSE_LIST_SCREENS.INITIAL]: (
      <AdminList listItems={data} headerItems={HOUSES_LIST_HEADER_ITEMS} />
    ),
  };
}
