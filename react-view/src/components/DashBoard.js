import React, { Component } from "react";
import Schedule from "./Schedule/Schedule";
import { connect } from "react-redux";
import { getSchedules } from "../actions/scheduleActions";
import PropTypes from "prop-types";
import "../App.css";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";

class DashBoard extends Component {
  componentDidMount() {
    this.props.getSchedules();
    console.log("at did mount");
  }

  render() {
    const { schedules } = this.props.schedule;
    console.log(schedules);
    console.log("after displaying the schedules gonna assign to event list");

    const eventList = [];
    for (let i = 0; i < schedules.length; i++) {
      eventList.push({
        title: schedules[i].title,
        date: schedules[i].date
      });
    }
    console.log(eventList);
    return (
      <div className="schedules">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">schedules</h1>
              <br />
              <br />
              <hr />
              {schedules.map(schedule => (
                <Schedule key={schedule.id} schedule={schedule} />
              ))}

              <div className="container">
                <FullCalendar
                  header={{
                    left: "title",
                    center: "dayGridMonth,timeGridWeek",
                    right: "today prev,next "
                  }}
                  timeZone={"America/New_York"}
                  defaultView="dayGridMonth"
                  plugins={[timeGridPlugin, dayGridPlugin]}
                  height={600}
                  //timeFormat={"hh:mm"}
                  events={eventList}
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

DashBoard.propTypes = {
  schedule: PropTypes.object.isRequired,
  getSchedules: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  schedule: state.schedule
});

export default connect(
  mapStateToProps,
  { getSchedules }
)(DashBoard);
