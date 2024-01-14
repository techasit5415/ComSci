const { REST, Routes } = require('discord.js');
const dotenv = require('dotenv');
dotenv.config();

const commands = [
  {
    name: 'ping',
    description: 'Replies with Pong!',
  },
];

const rest = new REST({ version: '10' }).setToken(process.env.TOKEN);

async function registerCommands() {
  try {
    console.log('Started refreshing application (/) commands.');

    // แก้ไข Routes.applicationCommands เป็น Routes.applicationGuildCommands หรือให้ค่า 'guild_id'
    await rest.put(Routes.applicationGuildCommands(process.env.ClientID, 'guild_id'), { body: commands });

    console.log('Successfully reloaded application (/) commands.');
  } catch (error) {
    console.error(error);
  }
}

// เรียกใช้ async function
registerCommands();
