import axios from "axios";
import { GET_ERRORS, GET_MEMBER, GET_MEMBERS, GET_ORGANIZATION } from "./types";

export const createOrganization = (organization, history) => async dispatch => {
  try {
    await axios.post("/api/organization/create", organization);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};
