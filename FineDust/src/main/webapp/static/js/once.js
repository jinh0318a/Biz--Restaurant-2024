document.addEventListener("DOMContentLoaded", () => {
  const PM10 = document.querySelector("td.PM10");
  const PM25 = document.querySelector("td.PM25");

  const applyColorPM10 = (PM10) => {
    const PM10_value = parseFloat(PM10.textContent);
    PM10.style.color = "white";
    if (PM10_value >= 151) {
      PM10.style.backgroundColor = "#e64746";
    } else if (PM10_value >= 81 && PM10_value <= 150) {
      PM10.style.backgroundColor = "#fda60d";
    } else if (PM10_value >= 31 && PM10_value <= 80) {
      PM10.style.backgroundColor = "#02bc30";
    } else if (PM10_value <= 30) {
      PM10.style.backgroundColor = "#2286f7";
    }
  };

  const applyColorPM25 = (PM25) => {
    const PM25_value = parseFloat(PM25.textContent);
    PM25.style.color = "white";
    if (PM25_value >= 76) {
      PM25.style.backgroundColor = "#e64746";
    } else if (PM25_value >= 36 && PM25_value <= 75) {
      PM25.style.backgroundColor = "#fda60d";
    } else if (PM25_value >= 16 && PM25_value <= 35) {
      PM25.style.backgroundColor = "#02bc30";
    } else if (PM25_value <= 15) {
      PM25.style.backgroundColor = "#2286f7";
    }
  };

  applyColorPM10(PM10);
  applyColorPM25(PM25);
});
