document.addEventListener("DOMContentLoaded", () => {
  const dust_list = document.querySelector("ul.finedust-list");

  const getDetail = async (e) => {
    const target = e.target;
    if (target.tagName === "SPAN" && target.classList.contains("item")) {
      const place = target.closest("LI").dataset.place;

      const detailURL = `${rootPath}detail?place=${place}`;
      const response = await fetch(detailURL);
      const html = await response.text();
      document.querySelector("article.detail").innerHTML = html;
    }
  };
  dust_list.addEventListener("click", getDetail);
});
