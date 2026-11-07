import {CHARACTERS} from "../assets/characters.js";

function HomePage({ opponentCharacter, setOpponentCharacter, setPage, setMoveSearch, moveSearch }) {
    return(
        <>
            <header id="title">
                <h1>
                    TEKKEN PUNISHMENT
                </h1>
            </header>
            <section id = "middle-block">
                <div id = "selected-character">
                    <img src={opponentCharacter.portrait} alt="Foto del personaje"/>
                    <h2>{opponentCharacter.name}</h2>
                    <h3>{opponentCharacter.style}</h3>
                    <input type= "text"
                           placeholder={"..."} onChange={(e)=>setMoveSearch(e.target.value)} value={moveSearch}/>
                    <button id = "bt-punishment" onClick={()=>setPage("PunishPage")}> PUNISH HIM</button>
                </div>
                <div id = "choose-character">
                    {CHARACTERS.map(character => (
                        <button key={character.id} onClick={()=> setOpponentCharacter(character)}>
                            <img src = {character.icon} alt={character.name}/>
                        </button>
                    ))}

                </div>
            </section>
            <footer id= "footer-hp">
                Y AQUI ESTA EL FOOTER

            </footer>

        </>
    );

}
export default HomePage;