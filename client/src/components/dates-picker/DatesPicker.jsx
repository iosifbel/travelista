import { addDays, format } from "date-fns";
import React, { useEffect, useState } from "react";
import { DateRange } from "react-date-range";
import "./dates-picker.css";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import { BsCalendarWeek } from "react-icons/bs";
import { useDispatch, useSelector } from "react-redux";
import { updateSelectedDates } from "../../redux/actions/planner";

export const DatesPicker = () => {
  const dispatch = useDispatch();
  const selectedDates = useSelector((state) => state.planner.selectedDates);

  const [showDatesPicker, setShowDatesPicker] = useState(false);

  const [dateRange, setDateRange] = useState([
    {
      startDate: new Date(),
      endDate: addDays(new Date(), 7),
      key: "selection",
    },
  ]);

  const handleSelect = (datesData) => {
    setDateRange([datesData]);

    const selectedDates = {
      startDate: format(datesData.startDate, "MMM/dd"),
      endDate: format(datesData.endDate, "MMM/dd"),
    };

    dispatch(updateSelectedDates(selectedDates));
  };

  return (
    <div className="dates-picker">
      <div className="input-container">
        <div className="text-container">
          <span className="text">Dates (optional):</span>
          <div className="selected-dates">
            {selectedDates ? (
              <>
                <span className="date">{selectedDates.startDate}</span>
                <span className="divider"></span>
                <span className="date">
                  {selectedDates.endDate === selectedDates.startDate
                    ? "End Date"
                    : selectedDates.endDate}
                </span>
              </>
            ) : (
              <>
                <span className="date">Start Date</span>
                <span className="divider"></span>
                <span className="date">End Date</span>
              </>
            )}
          </div>
        </div>
        <BsCalendarWeek
          className="calendar-icon"
          onClick={() => setShowDatesPicker(!showDatesPicker)}
        />
      </div>

      {showDatesPicker && (
        <DateRange
          onChange={(item) => handleSelect(item.selection)}
          editableDateInputs={true}
          moveRangeOnFirstSelection={false}
          ranges={dateRange}
          months={2}
          direction="horizontal"
          className="date-range"
        />
      )}
    </div>
  );
};
