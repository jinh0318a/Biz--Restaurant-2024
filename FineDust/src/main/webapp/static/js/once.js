document.addEventListener("DOMContentLoaded", () => {
  const PM10 = document.querySelector("td.PM10");
  const PM25 = document.querySelector("td.PM25");

  const applyColorPM10 = (PM10) => {
    const PM10_value = parseFloat(PM10.textContent);
    console.log(PM10_value);
    if (PM10_value >= 151) {
      PM10.style.backgroundColor = "red";
    } else if (PM10_value >= 81 && PM10_value <= 150) {
      PM10.style.backgroundColor = "yellow";
    } else if (PM10_value >= 31 && PM10_value <= 80) {
      PM10.style.backgroundColor = "green";
    } else if (PM10_value <= 30) {
      PM10.style.backgroundColor = "blue";
    }
  };

  const applyColorPM25 = (PM25) => {
    const PM25_value = parseFloat(PM25.textContent);
    if (PM25_value >= 76) {
      PM25.style.backgroundColor = "red";
    } else if (PM25_value >= 36 && PM25_value <= 75) {
      PM25.style.backgroundColor = "yellow";
    } else if (PM25_value >= 16 && PM25_value <= 35) {
      PM25.style.backgroundColor = "green";
    } else if (PM25_value <= 15) {
      PM25.style.backgroundColor = "blue";
    }
  };

  applyColorPM10(PM10);
  applyColorPM25(PM25);
});
