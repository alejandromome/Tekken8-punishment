
import './App.css'
import {useId, useState} from "react";

function App() {
    const [selectedCharacter1, setSelectedCharacter1] = useState({name: "none", style: "none"});
    const [selectedCharacter2, setSelectedCharacter2] = useState({name: "none", style: "none"});
    const [moveSearch, setMoveSearch] = useState("");
    const [page, setPage] = useState("HomePage")
    const punishes = [{move:"", startUp:"", damage:"" }]
    if (page === "HomePage"){
        return (
            <>
                <header id="title">
                    <h1>
                        TEKKEN PUNISHMENT
                    </h1>
                </header>
                <section id = "middle-block">
                    <div id = "selected-character">
                        <img src="" alt="Foto del personaje"/>
                        <h2>{selectedCharacter1.name}</h2>
                        <h3>{selectedCharacter1.style}</h3>
                    </div>
                    <div id = "choose-character">
                        <button onClick={()=> setSelectedCharacter1({name: "Yoshimitsu", style:"Maninjutsu"})}>Yoshimitsu</button>
                        <button onClick={()=>setSelectedCharacter1({name: "Alisa", style:"High mobility"})}>Alisa</button>
                        <button></button>
                        <button></button>
                        <button></button>

                        HLISTA DE PERSONAKES
                    </div>
                </section>
                <footer>
                    Y AQUI ESTA EL FOOTER
                    <button id = "bt-punishment" onClick={()=>setPage("PunishPage")}> PUNISH</button>
                </footer>

            </>
        );
    } else if (page === "PunishPage"){
        return(<>
            <header id="title">
                <h1>
                    TEKKEN PUNISHMENT MATCHUP
                </h1>
            </header>
            <section id = "middle-block">
                <div id = "selected-character">
                    <img src="" alt="Foto del personaje"/>
                    <h2>{selectedCharacter1.name}</h2>
                    <h3>{selectedCharacter1.style}</h3>
                </div>
                <div id = "choose-character">
                    {selectedCharacter2.name === "none" ?(
                        <div>
                        <button onClick={()=> setSelectedCharacter2({name: "Yoshimitsu", style:"Maninjutsu"})}>Yoshimitsu</button>
                        <button onClick={()=>setSelectedCharacter2({name: "Alisa", style:"High mobility"})}>Alisa</button>
                        <button></button>
                        <button></button>
                        </div>) : (
                        <div>

                        <img src="" alt="Foto del personaje"/>
                        <h2>{selectedCharacter2.name}</h2>
                        <h3>{selectedCharacter2.style}</h3>
                            <input type= "text"
                                   placeholder={"..."} onChange={(e)=>setMoveSearch(e.target.value)} value={moveSearch}/>
                            <button onClick={()=> {setSelectedCharacter2({name: "none", style:"none"}); setMoveSearch("")}}>Select other character</button>
                        </div>
                    )


                    }

                </div>
            </section>
            <section id = "guaranteed-punishers">
               <table>
                   <thead>
                   <tr>
                       <th>PUNISH</th>
                       <th>STARTUP</th>
                       <th>DAMAGE</th>
                   </tr>
                   </thead>
                   <tbody>
                       {punishes.map((punish) => (
                           <tr>
                               <td> {punish.move}</td>
                               <td> {punish.startUp}</td>
                               <td> {punish.damage}</td>
                           </tr>
                       ))}
                   </tbody>
               </table>
            </section>
            <footer>
                Y AQUI ESTA EL FOOTER
                <button id = "bt-return" onClick={()=>setPage("HomePage")}> Return to character selection</button>
            </footer>

        </>);
    }

}

export default App
