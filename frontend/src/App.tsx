import { useState } from "react";
import './App.css'

function App() {
    const [isOpenAdd, setIsOpenAdd] = useState(false);
  return (
    <div className="app-layout">
      <aside className="sidebar">
        <div className="brand">Tsundoku Tracker</div>

        <nav className="sidebar-nav">
          <a className="nav-item active" href="#">
            Library
          </a>
          <a className="nav-item" href="#">
            Explore
          </a>
        </nav>
      </aside>

      <main className="main-content">
        <header className="page-header">
          <h1>Tsundoku Library</h1>
        </header>

        <div className="button-area">
            <button className="add-button" onClick={() => setIsOpenAdd(true)}>Add new tsundoku</button>
        </div>

        <section className="content-area">
          <h2>Welcome to Tsundoku Tracker</h2>
          <p>Your personal reading space starts here.</p>
        </section>

        {isOpenAdd && (
            <div>Add form</div>)}
      </main>
    </div>
  )
}

export default App
