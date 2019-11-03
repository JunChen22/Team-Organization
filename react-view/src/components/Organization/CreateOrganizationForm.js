import React from "react";
import { Link } from "react-router-dom";

const CreateScheduleForm = () => {
  return (
    <React.Fragment>
      <Link to="/organization/create" className="btn btn-lg btn-info">
        create a organization
      </Link>
    </React.Fragment>
  );
};

export default CreateScheduleForm;
