import { getAllAdvertisements } from "../services/AdvertisementService.js";

async function renderAdvertisements() {
    const advertisements = await getAllAdvertisements();
    advertisements.forEach((element) => {
        let { id, title, description } = element;
        let nowyDiv = document.createElement("div");
        nowyDiv.classList.add("item-advertisement"); // Dodaje klasę CSS



        let h1 = document.createElement("h1");
        h1.textContent = `Tytuł: ${title}`;

        let p = document.createElement("p");
        p.textContent = `Opis: ${description}`;

        nowyDiv.appendChild(h1);
        nowyDiv.appendChild(p);

        document.getElementById("container-for-advertisements").appendChild(nowyDiv);
    });
}

window.addEventListener('load', () => {
    renderAdvertisements();
});


