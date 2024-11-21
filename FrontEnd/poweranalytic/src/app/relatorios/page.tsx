"use client";
import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js';
import Header from '@/components/Header';
import Footer from '@/components/Footer';


ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

const Relatorios = () => {

  const data = {
    labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio'], 
    datasets: [
      {
        label: 'Lixo Eletrônico Reciclado (kg)',
        data: [100, 200, 150, 250, 300], 
        backgroundColor: 'rgba(0, 255, 0, 0.6)', 
        borderColor: 'rgba(0, 255, 0, 1)', 
        borderWidth: 1,
      },
      {
        label: 'Número de Peças Recicladas',
        data: [150, 250, 200, 350, 400], 
        backgroundColor: 'rgba(0, 0, 255, 0.6)', 
        borderColor: 'rgba(0, 0, 255, 1)',
        borderWidth: 1,
      },
    ],
  };

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'Quantidade de Lixo Eletrônico Reciclado e Número de Peças Recicladas',
      },
    },
  };

  return (
    <div className="bg-gray-900 text-white min-h-screen py-16 mt-12">
      <Header />
      <h2 className="text-4xl font-bold text-neon-green mb-8 text-center">Relatórios de Reciclagem Energética</h2>
      <p className="text-lg text-center mb-8">
        Acompanhe o impacto da reciclagem energética. Veja os dados atualizados sobre a quantidade de lixo eletrônico reciclado.
      </p>

      <div className="max-w-4xl mx-auto mb-8">
        <Line data={data} options={options} />
      </div>

     <Footer />
    </div>
  );
};

export default Relatorios;
