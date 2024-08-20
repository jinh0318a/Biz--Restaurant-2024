document.addEventListener("DOMContentLoaded", () => {
  const dust_list = document.querySelector("ul.finedust-list");

  const colorHandler = () => {
    const detail = document.querySelector("article.detail");
    const detail_list = detail.querySelector("ul.finedust-list");

    const PM10 = detail_list.querySelectorAll("span.PM10");
    const PM25 = detail_list.querySelectorAll("span.PM25");

    const applyColorPM10 = (elements) => {
      elements.forEach((element) => {
        const value = parseFloat(element.textContent);
        if (isNaN(value)) return;

        if (value >= 151) {
          element.style.backgroundColor = "red";
        } else if (value >= 81 && value <= 150) {
          element.style.backgroundColor = "yellow";
        } else if (value >= 31 && value <= 80) {
          element.style.backgroundColor = "green";
        } else if (value <= 30) {
          element.style.backgroundColor = "blue";
        }
      });
    };

    const applyColorPM25 = (elements) => {
      elements.forEach((element) => {
        const value = parseFloat(element.textContent);
        if (isNaN(value)) return;

        if (value >= 76) {
          element.style.backgroundColor = "red";
        } else if (value >= 36 && value <= 75) {
          element.style.backgroundColor = "yellow";
        } else if (value >= 16 && value <= 35) {
          element.style.backgroundColor = "green";
        } else if (value <= 15) {
          element.style.backgroundColor = "blue";
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
