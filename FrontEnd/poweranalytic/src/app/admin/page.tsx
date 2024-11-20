// src/app/admin.tsx
import Header from '@/components/Header';
import Footer from '@/components/Footer';

const Admin = () => {
  return (
    <div className="bg-gray-900 text-white min-h-screen">
      <Header />
      <main className="flex flex-col items-center justify-center text-center px-6 py-16 space-y-8">
        <h2 className="text-4xl font-bold text-neon-green shadow-lg">Administração Interna</h2>
        <p className="max-w-2xl text-lg">
          Acompanhe e monitore os dados enviados pelas indústrias parceiras sobre a quantidade de lixo eletrônico coletado.
        </p>

        <div className="space-y-4">
          {/* Exemplo de tabela com dados ou informações de monitoramento */}
          <div className="w-full bg-gray-800 p-4 rounded">
            <p className="text-center">Dados de monitoramento</p>
          </div>
        </div>
      </main>
      
    </div>
  );
};

export default Admin;
