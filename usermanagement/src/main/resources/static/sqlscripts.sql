CREATE TABLE [dbo].[user](
	[id] [bigint] NOT NULL,
	[user_id] [varchar](255) NULL,
	[channel_id] [varchar](255) NULL,
	[distributor_id] [varchar](255) NULL,
	[roles] [varchar](255) NULL,

PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]