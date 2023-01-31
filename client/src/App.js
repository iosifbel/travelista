import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { LandingPage } from './views/landing/LandingPage';

import 'bootstrap/dist/css/bootstrap.min.css'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LandingPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
