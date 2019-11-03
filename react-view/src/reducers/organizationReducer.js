import { GET_ORGANIZATION } from "../actions/types";

const initialState = {};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_ORGANIZATION:
      return {
        ...state,
        schedules: action.payload
      };
    default:
      return state;
  }
}
