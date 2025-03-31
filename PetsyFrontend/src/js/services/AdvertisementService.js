export async function getAllAdvertisements(){
    try{
        const response = await fetch("http://localhost:8080/api/v1/advertisement",{
            method: "GET"
        });

        if (!response.ok) throw new Error("Cos poszlo nie tak");

        const data = await response.json();
        console.log(data);
        return data;
    }catch (error){
        console.error("Błąd logowania:", error.message);
        alert("Błąd logowania: " + error.message);
    }
}