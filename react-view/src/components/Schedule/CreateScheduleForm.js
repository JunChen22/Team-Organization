import React from "react";
import { Link } from "react-router-dom";

const CreateScheduleForm = () => {
  return (
    <React.Fragment>
      <Link to="/addschedule" className="btn btn-lg btn-info">
        add a schedule
      </Link>
    </React.Fragment>
  );
};

export default CreateScheduleForm;
