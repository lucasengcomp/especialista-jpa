insert into produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 499.0, date_sub(sysdate(), interval 1 day), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, data_criacao, descricao) values (3, 'Câmera GO Pro', 1499.0, date_sub(sysdate(), interval 1 day), 'Uma boa camera para esportes.');

insert into cliente (id, nome) values (1, 'Ana Caroliny');
insert into cliente (id, nome) values (5, 'Leila Galvao');

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 100.0, 'AGUARDANDO');

insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);

insert into categoria(id, nome) values (1, 'Eletrônicos')