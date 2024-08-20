document.addEventListener("DOMContentLoaded", () => {
  const dust_list = document.querySelector("ul.finedust-list");

  const colorHandler = () => {
    const detail = document.querySelector("article.detail");
    const detail_list = detail.querySelector("ul.finedust-list");

    const PM10 = detail_list.querySelectorAll("span.PM10");
    const PM25 = detail_list.querySelectorAll("span.PM25");

    const applyColorPM10 = (PM10) => {
      PM10.forEach((PM10) => {
        const value = parseFloat(PM10.textContent);
        if (isNaN(value)) return;
        PM10.style.color = "white";
        if (value >= 151) {
          PM10.style.backgroundColor = "#e64746";
        } else if (value >= 81 && value <= 150) {
          PM10.style.backgroundColor = "#fda60d";
        } else if (value >= 31 && value <= 80) {
          PM10.style.backgroundColor = "#02bc30";
        } else if (value <= 30) {
          PM10.style.backgroundColor = "#2286f7";
        }
      });
    };

    const applyColorPM25 = (PM25) => {
      PM25.forEach((PM25) => {
        const value = parseFloat(PM25.textContent);
        if (isNaN(value)) return;
        PM25.style.color = "white";
        if (value >= 76) {
          PM25.style.backgroundColor = "#e64746";
        } else if (value >= 36 && value <= 75) {
          PM25.style.backgroundColor = "#fda60d";
        } else if (value >= 16 && value <= 35) {
          PM25.style.backgroundColor = "#02bc30";
        } else if (value <= 15) {
          PM25.style.backgroundColor = "#2286f7";
        }
      });
    };

    applyColorPM10(PM10);
    applyColorPM25(PM25);
  };

  const getDetail = async (e) => {
    const target = e.target;
    if (target.tagName === "SPAN" && target.classList.contains("item")) {
      const place = target.closest("LI").dataset.place;

      const detailURL = `${rootPath}detail?place=${place}`;
      const response = await fetch(detailURL);
      const html = await response.text();
      document.querySelector("article.detail").innerHTML = html;

      setTimeout(colorHandler, 0);
    }
  };
  dust_list.addEventListener("click", getDetail);
});
