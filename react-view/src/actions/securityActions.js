import axios from "axios";
import { GET_ERRORS } from "./types";

export const createNewUser = (newUser, history) => async dispatch => {
  console.log("I was action ");
  console.log(newUser);
  console.log(history);
  try {
    await axios.post("/api/user/register", newUser);
    history.push("/login");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (err) {
    console.log("kept getting errors");
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};
