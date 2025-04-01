export async function getAllAdvertisements(){
    try{
        const response = await fetch("http://localhost:8080/api/v1/advertisement",{
            method: "GET"
        });

        if (!response.ok) throw new Error("Cos poszlo nie tak");

        return await response.json();
    }catch (error){
        console.error("Błąd pobierania ogłoszeń:", error.message);
        return [];
    }
}