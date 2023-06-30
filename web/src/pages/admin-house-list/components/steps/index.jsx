import { HOUSE_LIST_SCREENS } from "../../../../app-constants";
import { AdminList } from "../../../../components";
import { HOUSES_LIST_HEADER_ITEMS } from "../../constants";

export function HousesListSteps({ data }) {
  return {
    [HOUSE_LIST_SCREENS.INITIAL]: (
      <AdminList data={data} headerItems={HOUSES_LIST_HEADER_ITEMS} />
    ),
  };
}
